package view;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AppCriteria1 {

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("AtividadeVol1")
                .createEntityManager();
        new IniciandorBancoDados(em).dadosIniciais();
        
//        letraA(em);
//        letraB(em);
//        letraC(em);
//        letraD(em);
//        letraE(em);
//        letraF(em);
    }

    //Uma consulta que selecione todos os livros dos autores que não nasceram no dia
    //21/11/1982.
    private static void letraA(EntityManager em) {
    }

    //Uma consulta que selecione todos os professores que possuem Telefone e residem
    //na rua “Que atividade fácil”.
    private static void letraB(EntityManager em) {
    }

    //Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma
    //consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos
    //que pertencem a turma de 2019.1.
    private static void letraC(EntityManager em) {
    }

    //Uma consulta que seleciona todas os Professores que possuem algum telefone
    //que termina em 8.
    private static void letraD(EntityManager em) {
    }

    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e
    //tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void letraE(EntityManager em) {
    }

    //Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void letraF(EntityManager em) {
    }

}
