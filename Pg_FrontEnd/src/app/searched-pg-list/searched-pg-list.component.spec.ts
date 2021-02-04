import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchedPgListComponent } from './searched-pg-list.component';

describe('SearchedPgListComponent', () => {
  let component: SearchedPgListComponent;
  let fixture: ComponentFixture<SearchedPgListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchedPgListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchedPgListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
