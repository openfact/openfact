import { KEYCLOAK_HTTP_PROVIDER, KeycloakHttp } from './keycloak/keycloak.http';
import { TranslateLoader, TranslateModule, TranslateStaticLoader } from 'ng2-translate';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { Http } from '@angular/http';
import { HttpModule } from '@angular/http';
import { KeycloakService } from './keycloak/keycloak.service';
import { Ng2BootstrapModule } from 'ng2-bootstrap';
import { NgModule } from '@angular/core';

export function createTranslateLoader(http: Http) {
  return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,

    Ng2BootstrapModule.forRoot(),
    TranslateModule.forRoot({
      provide: TranslateLoader,
      useFactory: (createTranslateLoader),
      deps: [Http]
    }),
  ],
  providers: [
    KeycloakService,
    KEYCLOAK_HTTP_PROVIDER
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
