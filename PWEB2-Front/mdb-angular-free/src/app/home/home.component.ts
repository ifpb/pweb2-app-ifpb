import { Component, OnInit } from '@angular/core';
import { CampiService } from '../services/campi.service';
import { QuantCampusCursoDTO } from '../models/QuantCampusCursoDTO';
import { NomeCursosDTO } from '../models/NomeCursosDTO';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  cursosTotalAlunos: QuantCampusCursoDTO[];
  quantCursosTotal: number[] = [];
  nomesCursosTotal: string[] = [];

  cursosEgressoAlunos: QuantCampusCursoDTO[];
  quantCursosEgressos: number[] = [];
  nomesCursosEgressos: string[] = [];

  nomesCursos: NomeCursosDTO[];

  cursoSelecionado: string;
  meuGrafico: any[] = [];
  quantCursosGrafico: number[] = [];
  nomesCursosGrafico: string[] = [];

  situacoes: string[] = [
    "Concluído",
    "Trancado",
    "Concludente",
    "Matriculado",
    "Formado",
    "Jubilado",
    "Egresso",
    "Evasão",
    "Cancelamento Compulsório",
    "Cancelado",
  ]

  constructor(
    private campiService: CampiService
  ) { }

  ngOnInit() {
    this.campiService.getQuantCursoPorCampus("JOÃO PESSOA", "MATRICULADO").subscribe(res => {
      this.cursosTotalAlunos = res.body;
      this.cursosTotalAlunos.forEach(c => {
        this.quantCursosTotal.push(c.quant);
        this.nomesCursosTotal.push(c.nomeCurso);
        this.chartDatasets = [{ data: this.quantCursosTotal, label: 'CURSOS' }]
        this.chartLabels = this.nomesCursosTotal;
      })
    });

    this.campiService.getQuantCursoPorCampus("JOÃO PESSOA", "EGRESSO").subscribe(res => {
      this.cursosEgressoAlunos = res.body;
      this.cursosEgressoAlunos.forEach(c => {
        this.quantCursosEgressos.push(c.quant);
        this.nomesCursosEgressos.push(c.nomeCurso);
        this.chartDatasetsEgressos = [{ data: this.quantCursosEgressos, label: 'EGRESSOS' }]
        this.chartLabelsEgressos = this.nomesCursosEgressos;
      })
    });

    this.campiService.getCursos("JOÃO PESSOA").subscribe(res => {
      this.nomesCursos = res.body;
    })

  }
  public chartType2: string = 'bar'; // GRafico de barra
  public chartType: string = 'pie';  // Grafico de Pizza

  public chartDatasets: Array<any> = [
    { data: [300, 50, 100, 40, 120, 100, 200, 10, 10, 100], label: 'DATASET' }
  ];

  public chartDatasetsEgressos: Array<any> = [
    { data: [300, 50, 100, 40, 120, 100, 200, 10, 10, 100], label: 'DATASET' }
  ];

  public chartDatasetsBarra: Array<any> = [
    { data: [300, 50, 100, 40, 120, 100, 200, 10, 10, 100], label: 'DATASET' }
  ];

  public chartLabels: Array<any> = ['Red', 'Green', 'Yellow', 'Grey', 'Dark Grey', 'Red', 'Green', 'Yellow', 'Grey', 'Dark Grey'];

  public chartLabelsEgressos: Array<any> = ['Red', 'Green', 'Yellow', 'Grey', 'Dark Grey', 'Red', 'Green', 'Yellow', 'Grey', 'Dark Grey'];

  public chartLabelsBarra: Array<any> = ['Red', 'Green', 'Yellow', 'Grey', 'Dark Grey', 'Red', 'Green', 'Yellow', 'Grey', 'Dark Grey'];


  public chartColors: Array<any> = [
    {
      backgroundColor: ['#F7464A', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360', '#FF8BAB', '#FF6GC6', '#FF100G', '#FFF001', '#FF8BDA'],
      hoverBackgroundColor: ['#FF5A5E', '#5AD3D1', '#FFC870', '#A8B3C5', '#616774', '#FF8BAB', '#FF6GC6', '#FF100G', '#FFF001', '#FF8BDA'],
      borderWidth: 1,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

  mudarCurso(curso) {
    console.log(curso);
    this.cursoSelecionado = curso;
    this.situacoes.forEach(s => {
      this.campiService.getNomeCampusCursoSituacao("JOÃO PESSOA", curso, s).subscribe(res => {
        this.meuGrafico = [];
        this.meuGrafico.push({ curso: curso, valor: res.body.quant });
      })
    });
    this.meuGrafico.forEach(m => {
      this.quantCursosGrafico.push(m.valor);
      this.nomesCursosGrafico.push(m.curso);
      this.chartDatasetsBarra = [{ data: this.quantCursosGrafico, label: 'BARRAS' }]
      this.chartLabelsBarra = this.nomesCursosGrafico;
    });
  }

}
