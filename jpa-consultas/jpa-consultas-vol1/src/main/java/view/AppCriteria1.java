package view;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

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

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
        Root<Professor> root = criteria.from(Professor.class);
        Join<Professor, Endereco> join = root.join("endereco");

        Predicate telefone = builder.isNotEmpty(root.get("telefones"));
        Predicate rua = builder.equal(join.get("rua"),"Que atividade facil");

        criteria.select(root).where(telefone,rua);
        TypedQuery<Professor> query = em.createQuery(criteria);
        query.getResultList().forEach(
                p-> System.out.println(p.getNome())
        );
    }

    //Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma
    //consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos
    //que pertencem a turma de 2019.1.
    private static void letraC(EntityManager em) {
    }

    //Uma consulta que seleciona todas os Professores que possuem algum telefone
    //que termina em 8.
    private static void letraD(EntityManager em) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
        Root<Professor> root = criteria.from(Professor.class);
        Join<Professor, Telefone> join = root.join("telefones");
        Predicate telefoneTerminaEm8 = builder.like(join.get("numero"),"%8");
        criteria.where(telefoneTerminaEm8);
        em.createQuery(criteria).getResultList().forEach(
                p-> System.out.println("Professor: "+p.getNome())
        );
    }

    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e
    //tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void letraE(EntityManager em) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
        Root<Livro> root = criteria.from(Livro.class);
        Join<Livro, Autor> join = root.join("autores");
        Predicate cidade = builder.like(join.get("endereco").get("cidade"),"%Cajazeiras%");
        Predicate entreLancamento = builder.between(root.get("lancamento"),"2019-01-01","2019-12-12");
        criteria.where(cidade,entreLancamento);
        em.createQuery(criteria).getResultList().forEach(
                l-> System.out.println("Livro: "+l.getNome())
        );
    }

    //Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void letraF(EntityManager em) {
    }

}
