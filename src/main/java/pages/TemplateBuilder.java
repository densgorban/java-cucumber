package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateBuilder {

    private final Page page;

    public TemplateBuilder(Page page) {
        this.page = page;
    }

    public TemplateBuilder setName(String templateName) {
        page.locator("input.input-title").click();
        page.locator("input.input-title").fill(templateName);
        return this;
    }

    public TemplateBuilder saveAsNewTemplate() {
        page.locator("button:has-text('Save As a New Template')").click();
        return this;
    }

    public TemplateBuilder updateTemplate() {
        page.locator("button:has-text('Update')").click();
        return this;
    }

    @Step
    public TemplateBuilder successMessage() {
        page.locator("div[data-key='success']").isVisible();
        return this;
    }

//    <div role="alert" data-key="success" class="slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage" data-aura-rendered-by="1452:0" data-aura-class="forceToastMessage" data-f6-region="" bis_skin_checked="1">
//    <span role="hidden" tabindex="0" data-toast-start="" data-aura-rendered-by="1454:0">
//    </span>
//    <div tabindex="0" class="slds-list--inline" data-aura-rendered-by="1455:0" bis_skin_checked="1">
//    <lightning-icon icon-name="utility:success" class="slds-icon-utility-success toastIcon slds-m-right--small slds-no-flex slds-align-top slds-icon_container" data-data-rendering-service-uid="407" data-aura-rendered-by="1457:0" lwc-4897l11qtae-host="">
//    <span lwc-4897l11qtae="" style="--sds-c-icon-color-background: var(--slds-c-icon-color-background, transparent)" part="boundary">
//    <lightning-primitive-icon lwc-4897l11qtae="" exportparts="icon" size="small" variant="inverse" lwc-601m5kls2of-host="">
//    <svg focusable="false" aria-hidden="true" viewBox="0 0 520 520" part="icon" lwc-601m5kls2of="" data-key="success" class="slds-icon slds-icon_small">
//    <g lwc-601m5kls2of="">
//    <path d="M260 20a240 240 0 100 480 240 240 0 100-480zm134 180L241 355c-6 6-16 6-22 0l-84-85c-6-6-6-16 0-22l22-22c6-6 16-6 22 0l44 45a10 10 0 0015 0l112-116c6-6 16-6 22 0l22 22c7 6 7 16 0 23z" lwc-601m5kls2of="">
//    </path></g></svg></lightning-primitive-icon>
//    <span class="slds-assistive-text" lwc-4897l11qtae="">Success</span></span></lightning-icon><div class="toastContent slds-notify__content" data-aura-rendered-by="1458:0" bis_skin_checked="1"><div class="slds-align-middle slds-hyphenate" data-aura-rendered-by="1459:0" bis_skin_checked="1"><div id="toastLabel1450:0" class="toastTitle slds-text-heading--small" data-aura-rendered-by="1461:0" bis_skin_checked="1">Success</div><div id="toastDescription1450:0" data-aura-rendered-by="1463:0" bis_skin_checked="1"><span class="toastMessage forceActionsText" data-aura-rendered-by="1468:0" data-aura-class="forceActionsText">Template has been updated</span></div></div><span class="slds-assistive-text" data-aura-rendered-by="1471:0">Press Control + F6 to navigate to the next toast notification or focusable region.</span></div><button class="slds-button slds-button_icon toastClose slds-notify__close slds-button--icon-inverse slds-button_icon-bare" data-aura-rendered-by="1474:0"><span aria-hidden="true" data-aura-rendered-by="1475:0"><lightning-icon icon-name="utility:close" class="slds-icon-utility-close slds-icon_container" data-aura-rendered-by="1476:0" lwc-4897l11qtae-host=""><span lwc-4897l11qtae="" style="--sds-c-icon-color-background: var(--slds-c-icon-color-background, transparent)" part="boundary"><lightning-primitive-icon lwc-4897l11qtae="" exportparts="icon" size="medium" variant="inverse" lwc-3bq099ugqsh-host=""><svg focusable="false" aria-hidden="true" viewBox="0 0 520 520" part="icon" lwc-3bq099ugqsh="" data-key="close" class="slds-icon"><g lwc-3bq099ugqsh=""><path d="M310 254l130-131c6-6 6-15 0-21l-20-21c-6-6-15-6-21 0L268 212a10 10 0 01-14 0L123 80c-6-6-15-6-21 0l-21 21c-6 6-6 15 0 21l131 131c4 4 4 10 0 14L80 399c-6 6-6 15 0 21l21 21c6 6 15 6 21 0l131-131a10 10 0 0114 0l131 131c6 6 15 6 21 0l21-21c6-6 6-15 0-21L310 268a10 10 0 010-14z" lwc-3bq099ugqsh=""></path></g></svg></lightning-primitive-icon></span></lightning-icon></span><span class="slds-assistive-text" data-aura-rendered-by="1477:0">Close</span></button></div><span role="hidden" tabindex="0" data-toast-end="" data-aura-rendered-by="1480:0"></span></div>
}
