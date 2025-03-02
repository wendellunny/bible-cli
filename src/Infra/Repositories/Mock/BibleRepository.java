package Infra.Repositories.Mock;

import Domain.Entities.Bible;

import java.util.ArrayList;
import java.util.List;

public class BibleRepository implements Domain.Api.Repositories.BibleRepository {

    /**
     * Fetch all bibles mock
     *
     * @return Bible[]
     */
    @Override
    public List<Bible> fetchAll() {
        List<Bible> bibles = new ArrayList<Bible>();

        bibles.add(new Bible(1, "João Ferreira de Almeida"));
        bibles.add(new Bible(2, "João Ferreira de Almeida Atualizada"));
        bibles.add(new Bible(3, "King James"));

        return bibles;
    }
}