class Aluno ():
    def __init__(self, id, nome, projetos=None, bolsas=None, matriculas=None):
        self.id = id
        self.nome = nome
        self.projetos = projetos
        self.bolsas = bolsas
        self.matriculas = matriculas

class Projeto:
    def __init__(self, titulo, tipo, participantes, areaConhecimento, dataInicio, dataFim, valor, unidadeOrganizacional):
        self.titulo = titulo
        self.tipo = tipo
        self.participantes = participantes
        self.areaConhecimento = areaConhecimento
        self.dataInicio = dataInicio
        self.dataFim = dataFim
        self.valor = valor
        self.unidadeOrganizacional = unidadeOrganizacional

    def __str__(self):
        return f'''
        {self.titulo}
        {self.tipo}
        {self.participantes}
        {self.areaConhecimento}
        {self.dataInicio}
        {self.dataFim}
        {self.valor}
        {self.unidadeOrganizacional}
        '''

class Bolsa:
    def __init__(self, categoria, quantidade):
        self.categoria = categoria
        self.quantidade = quantidade

class Matricula:
    def __init__(self, valor, situacao, cota, campus, curso):
        self.valor = valor
        self.situacao = situacao
        self.cota = cota
        self.campus = campus
        self.curso = curso

class RegistrationInfo:
    def __init__(self, curso, campus, quantMatriculasLimpas, totalAluno):
        self.curso = curso
        self.campus = campus
        self.quantMatriculasLimpas = quantMatriculasLimpas
        self.totalAluno = totalAluno

class StudentInfo:
    def __init__(self, campus, curso, situacao):
        self.campus = campus
        self.curso = curso
        self.situacao = situacao

class CampusInfo:
    def __init__(self, campus, quant, total):
        self.campus = campus
        self.quant = quant
        self.total = total
