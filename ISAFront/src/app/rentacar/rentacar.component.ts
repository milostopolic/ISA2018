import { Component, OnInit } from '@angular/core';
import { Rentacar } from 'src/app/model/Rentacar';
import { RentacarService } from 'src/app/services/rentacar.service';
import { ActivatedRoute } from '@angular/router';
import { Vehicle } from 'src/app/model/Vehicle';

@Component({
  selector: 'app-rentacar',
  templateUrl: './rentacar.component.html',
  styleUrls: ['./rentacar.component.css']
})
export class RentacarComponent implements OnInit {

  id;
  rentacar: Rentacar = new Rentacar();
  displayedColumns: string[] = ['manufacturer', 'model', 'productionyear', 'seats', 'type', 'price', 'book'];
  dataSource: Vehicle[];

  constructor(private rentacarService: RentacarService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.rentacarService.getRentacarById(this.id).subscribe(data => { this.rentacar = data; this.dataSource = data.vehiclesDTO });
  }

}
