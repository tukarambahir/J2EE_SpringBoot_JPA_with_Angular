import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePropertyDetailsComponent } from './update-property-details.component';

describe('UpdatePropertyDetailsComponent', () => {
  let component: UpdatePropertyDetailsComponent;
  let fixture: ComponentFixture<UpdatePropertyDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePropertyDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePropertyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
