import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { HeroisService } from '../herois/herois.service';
import { FormGroup } from '@angular/forms';
import { MessageService} from 'primeng/components/common/messageservice';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-cadastrar-heroi',
  templateUrl: './cadastrar-heroi.component.html',
  styleUrls: ['./cadastrar-heroi.component.css']
})
export class CadastrarHeroiComponent implements OnInit {

  @Output() cadastroHeroi = new EventEmitter();

  heroi: any;
  universos: Array<any>;

  constructor(private heroisService: HeroisService, private messageService: MessageService) {  }

  ngOnInit() {
    this.novocadastro();
    this.listaruniverso();
  }

  novocadastro() {
    this.heroi = {};
    this.universos = [{}];
  }

  listaruniverso() {
    this.heroisService.listaruniverso().subscribe(response => this.universos = response);
  }

  cadastro(frm: FormGroup) {
    this.heroisService.cadastro(this.heroi).subscribe(response => {
        this.novocadastro();
        frm.reset();
        this.messageService.add({severity: 'sucess', detail: 'Cadastro executado com sucesso!'});
        this.cadastroHeroi.emit(response);
    });
  }

}
