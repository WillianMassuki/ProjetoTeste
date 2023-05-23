import { Produto } from "../produto/produto";

export class Estoque
{
    codigoEstoque!: number;
    produto!: Produto;
    quantidade!: number;
    data!: Date;
    motivo!: String;
    documento!: String;


}