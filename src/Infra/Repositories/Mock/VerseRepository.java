package Infra.Repositories.Mock;

import Domain.Entities.Chapter;
import Domain.Entities.Verse;

import java.util.ArrayList;
import java.util.List;

public class VerseRepository implements Domain.Api.Repositories.VerseRepository {

    /**
     * Fetch all verses from chapter
     *
     * @param chapter Chapter
     * @return Verse[]
     */
    @Override
    public List<Verse> fetchByChapter(Chapter chapter) {
        List<Verse> verses = new ArrayList<Verse>();

        verses.add(new Verse(
            1,
            1,
            "No princípio Deus criou os céus e a terra",
            chapter
        ));
        verses.add(new Verse(
            2,
            2,
            "A terra porém estava sem forma e vazia; havia trevas sobre a face do abismo, " +
                "e o Espírito de Deus pairava sobre as águas",
            chapter
        ));
        verses.add(new Verse(
            3,
            3,
            "Disse Deus: Haja luz; e houve luz",
            chapter
        ));
        verses.add(new Verse(
            4,
            4,
            "E viu Deus que a luz era boa; e fez separação entre a luz e as trevas.",
            chapter
        ));
        verses.add(new Verse(
            5,
            5,
            "Chamou Deus à luz Dia e às trevas, Noite. Houve tarde e manhã, o primeiro dia.",
            chapter
        ));

        return verses;
    }
}