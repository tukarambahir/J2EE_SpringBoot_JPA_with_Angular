import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllpgComponent } from './admin-allpg.component';

describe('AdminAllpgComponent', () => {
  let component: AdminAllpgComponent;
  let fixture: ComponentFixture<AdminAllpgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllpgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllpgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
