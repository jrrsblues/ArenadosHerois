import { Component, OnInit } from '@angular/core';
import { HeroisService } from '../herois/herois.service';
import { MessageService } from 'primeng/api';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-alterar-heroi',
  templateUrl: './alterar-heroi.component.html',
  styleUrls: ['./alterar-heroi.component.css']
})
export class AlterarHeroiComponent implements OnInit {

  heroiids: Array<any>;
  heroi: any;

  constructor(private heroiService: HeroisService,
     private messageService: MessageService) { }

  ngOnInit() {
    this.novaAlteracao();
    this.listaridalterego();
  }

  novaAlteracao() {
    this.heroiids = [{}];
    this.heroi = {};
  }

  pesquisardadosheroi(frm: FormGroup) {
    this.heroiService.retornardadosdeheroi(this.heroi).subscribe(response => {
      frm.reset();
      this.pegardados();
    });
  }

  alterarardadosheroi(frm: FormGroup) {
    this.heroiService.alterardadosdeheroi(this.heroi).subscribe(response => {
      frm.reset();
      this.novaAlteracao();
    });
  }

  pegardados() {
    this.heroiService.capturardadosdeheroi().subscribe(response => this.heroi = response);
  }

  listaridalterego() {
    this.heroiService.listaridalterego().subscribe(response => this.heroiids = response);
  }

}
