import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllownersComponent } from './admin-allowners.component';

describe('AdminAllownersComponent', () => {
  let component: AdminAllownersComponent;
  let fixture: ComponentFixture<AdminAllownersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllownersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllownersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
