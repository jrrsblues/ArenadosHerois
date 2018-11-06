import { Component, OnInit } from '@angular/core';
import { HeroisService } from '../herois/herois.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-combateherois',
  templateUrl: './combateherois.component.html',
  styleUrls: ['./combateherois.component.css']
})
export class CombateheroisComponent implements OnInit {

  oponentes: any;
  vencedor: any;

  constructor(private heroisService: HeroisService) { }

  ngOnInit() {
    this.retornaoponentes();
    this.novocombate();
  }

  novocombate() {
    this.oponentes = {};
    this.vencedor = {};
  }

  retornavencedor() {
    this.heroisService.retornavencedor().subscribe(response => this.vencedor = response);
  }

  retornaoponentes() {
    this.heroisService.retornaoponentes().subscribe(response => this.oponentes = response);
  }

  resultadodacontenda(Frm: FormGroup) {
    this.heroisService.resultadodacontenda(this.oponentes).subscribe(response => {
      Frm.reset();
      this.retornavencedor();
    });
  }

}
