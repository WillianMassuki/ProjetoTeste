import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEstoqueComponent } from './listar-estoque.component';

describe('ListarEstoqueComponent', () => {
  let component: ListarEstoqueComponent;
  let fixture: ComponentFixture<ListarEstoqueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarEstoqueComponent]
    });
    fixture = TestBed.createComponent(ListarEstoqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
