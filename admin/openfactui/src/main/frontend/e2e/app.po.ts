import { browser, element, by } from 'protractor';

export class OpenfactuiPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('of-root h1')).getText();
  }
}
