import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { HeroisService } from '../herois/herois.service';
import { FormGroup } from '@angular/forms';
import { MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-dadosheroiespecifico',
  templateUrl: './dadosheroiespecifico.component.html',
  styleUrls: ['./dadosheroiespecifico.component.css']
})
export class DadosheroiespecificoComponent implements OnInit {

  heroi: any;

  constructor(private heroisService: HeroisService, private messageService: MessageService ) { }

  ngOnInit() {
    this.novaPesquisa();
  }

  novaPesquisa() {
    this.heroi = {};
  }


  pesquisarHeroi(frm: FormGroup) {
    this.heroisService.retornardadosdeheroi(this.heroi).subscribe(response => {
      frm.reset();
      this.novaPesquisa();
      this.listar();
    });
  }

  listar() {
    this.heroisService.capturardadosdeheroi().subscribe(response => this.heroi = response);
  }

}
