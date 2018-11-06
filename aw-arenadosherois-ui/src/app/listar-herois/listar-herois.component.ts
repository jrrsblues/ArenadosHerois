import { Component, OnInit } from '@angular/core';
import { HeroisService } from '../herois/herois.service';

@Component({

  templateUrl: './listar-herois.component.html',
  styleUrls: ['./listar-herois.component.css']
})
export class ListarHeroisComponent implements OnInit {

  herois: Array<any>;

  constructor(private heroisService: HeroisService) {  }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.heroisService.listar().subscribe(response => this.herois = response);
  }

}
