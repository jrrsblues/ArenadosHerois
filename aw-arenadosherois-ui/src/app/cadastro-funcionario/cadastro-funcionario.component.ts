import { Component, OnInit } from '@angular/core';
import { HeroisService } from '../herois/herois.service';
import { MessageService} from 'primeng/components/common/messageservice';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cadastro-funcionario',
  templateUrl: './cadastro-funcionario.component.html',
  styleUrls: ['./cadastro-funcionario.component.css']
})
export class CadastroFuncionarioComponent implements OnInit {

  departamentos: Array<any>;

  constructor(private heroisService: HeroisService, messageService: MessageService) { }

  ngOnInit() {
    this.novoFuncionario();
  }

  novoFuncionario() {
    this.departamentos = [{}];
  }

  cadastrar(frm: FormGroup) {
    console.log(frm.value);
  }

}
