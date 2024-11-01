FROM ubuntu:jammy

ARG DEBIAN_FRONTEND=noninteractive
ARG TZ=America/Los_Angeles
ARG DOCKER_IMAGE_NAME_TEMPLATE="mcr.microsoft.com/playwright/java:v%version%-jammy"

# === INSTALL JDK and Maven ===

RUN apt-get update && \
    apt-get install -y --no-install-recommends openjdk-21-jdk \
    # Install utilities required for downloading browsers
    wget \
    # Install utilities required for downloading driver
    unzip \
    # For the MSEdge install script
    gpg && \
    rm -rf /var/lib/apt/lists/* && \
    # Create the pwuser
    adduser pwuser

# Ubuntu 22.04 and earlier come with Maven 3.6.3 which fails with
# Java 21, so we install latest Maven from Apache instead.
RUN VERSION=3.9.6 && \
    wget -O - https://archive.apache.org/dist/maven/maven-3/$VERSION/binaries/apache-maven-$VERSION-bin.tar.gz | tar zxfv - -C /opt/ && \
    ln -s /opt/apache-maven-$VERSION/bin/mvn /usr/local/bin/

ARG PW_TARGET_ARCH
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-${PW_TARGET_ARCH}

# === BAKE BROWSERS INTO IMAGE ===

# Browsers will remain downloaded in `/ms-playwright`.
# Note: make sure to set 777 to the registry so that any user can access
# registry.

ENV PLAYWRIGHT_BROWSERS_PATH=/ms-playwright

RUN mkdir /ms-playwright && \
    mkdir /tmp/pw-java

COPY . /tmp/pw-java

RUN cd /tmp/pw-java && \
    ./scripts/download_driver.sh && \
    mvn install -D skipTests --no-transfer-progress && \
    DEBIAN_FRONTEND=noninteractive mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI \
                     -D exec.args="install-deps" -f playwright/pom.xml --no-transfer-progress && \
    mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI \
                     -D exec.args="install" -f playwright/pom.xml --no-transfer-progress && \
    mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI \
                     -D exec.args="mark-docker-image '${DOCKER_IMAGE_NAME_TEMPLATE}'" -f playwright/pom.xml --no-transfer-progress && \
    rm -rf /tmp/pw-java && \
    # Workaround for https://github.com/microsoft/playwright/issues/27313
    # While the gstreamer plugin load process can be in-process, it ended up throwing
    # an error that it can't have libsoup2 and libsoup3 in the same process because
    # libgstwebrtc is linked against libsoup2. So we just remove the plugin.
    if [ "$(uname -m)" = "aarch64" ]; then \
        rm /usr/lib/aarch64-linux-gnu/gstreamer-1.0/libgstwebrtc.so; \
    else \
        rm /usr/lib/x86_64-linux-gnu/gstreamer-1.0/libgstwebrtc.so; \
    fi && \
    chmod -R 777 $PLAYWRIGHT_BROWSERS_PATH