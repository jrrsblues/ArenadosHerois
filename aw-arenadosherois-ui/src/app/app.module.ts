import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { registerLocaleData } from '@angular/common';
import { NgModule, LOCALE_ID } from '@angular/core';
import localePt from '@angular/common/locales/pt';
import { RouterModule, Routes } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';

import {PanelModule} from 'primeng/panel';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { MessageService } from 'primeng/components/common/messageservice';
import { GrowlModule } from 'primeng/growl';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {CalendarModule} from 'primeng/calendar';
import {DropdownModule} from 'primeng/dropdown';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListarHeroisComponent } from './listar-herois/listar-herois.component';
import { CadastrarHeroiComponent } from './cadastrar-heroi/cadastrar-heroi.component';
import { AlterarHeroiComponent } from './alterar-heroi/alterar-heroi.component';
import { DadosheroiespecificoComponent } from './dadosheroiespecifico/dadosheroiespecifico.component';
import { CombateheroisComponent } from './combateherois/combateherois.component';
import { CadastroFuncionarioComponent } from './cadastro-funcionario/cadastro-funcionario.component';

registerLocaleData(localePt);

const appRoutes: Routes = [
  { path: 'listar', component: ListarHeroisComponent },
  { path: 'cadastrar', component: CadastrarHeroiComponent },
  { path: 'alterar', component: AlterarHeroiComponent },
  { path: 'pesquisar', component: DadosheroiespecificoComponent },
  { path: 'combate', component: CombateheroisComponent },
  { path: 'funcionarios', component: CadastroFuncionarioComponent },
  { path: '', redirectTo: '/listar', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListarHeroisComponent,
    CadastrarHeroiComponent,
    AlterarHeroiComponent,
    DadosheroiespecificoComponent,
    CombateheroisComponent,
    CadastroFuncionarioComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    GrowlModule,
    RadioButtonModule,
    BrowserAnimationsModule,
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    InputTextareaModule,
    CalendarModule,
    DropdownModule,
    PanelModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' },
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
