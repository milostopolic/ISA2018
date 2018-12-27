import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AirlinesEditComponent } from './airlines-edit.component';

describe('AirlinesEditComponent', () => {
  let component: AirlinesEditComponent;
  let fixture: ComponentFixture<AirlinesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AirlinesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AirlinesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
