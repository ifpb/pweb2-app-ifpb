import {Matricula} from '../models/Matricula';
import {Projetos} from '../models/Projetos';
import {Bolsas} from '../models/Bolsas';


export class Aluno {
    id: string;
    nome:string;
    matriculas: Matricula[]; // config matricula
    projetos:Projetos[] // Config Modelo
    bolsas:Bolsas[]; // Config Modelo

}