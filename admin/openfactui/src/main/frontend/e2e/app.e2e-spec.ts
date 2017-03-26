import { OpenfactuiPage } from './app.po';

describe('openfactui App', () => {
  let page: OpenfactuiPage;

  beforeEach(() => {
    page = new OpenfactuiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('of works!');
  });
});
