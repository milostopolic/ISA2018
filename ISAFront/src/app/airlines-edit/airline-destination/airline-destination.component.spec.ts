import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AirlineDestinationComponent } from './airline-destination.component';

describe('AirlineDestinationComponent', () => {
  let component: AirlineDestinationComponent;
  let fixture: ComponentFixture<AirlineDestinationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AirlineDestinationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AirlineDestinationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
