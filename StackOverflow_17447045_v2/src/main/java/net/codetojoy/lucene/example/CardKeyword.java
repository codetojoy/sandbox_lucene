
// originally from https://stackoverflow.com/a/36237769/12704
// by https://stackoverflow.com/users/462347/mike-b 

package net.codetojoy.lucene.example;

import java.util.HashSet;
import java.util.Set;

class CardKeyword implements Comparable<CardKeyword> {
    private final String stem;
    private final Set<String> terms = new HashSet<>();
    private int frequency;

    public CardKeyword(String stem) {
        this.stem = stem;
    }

    public void add(String term) {
        this.terms.add(term);
        this.frequency++;
    }

    @Override
    public int compareTo(CardKeyword keyword) {
        return Integer.valueOf(keyword.frequency).compareTo(this.frequency);
    }

    @Override
    public int hashCode() {
        return this.getStem().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CardKeyword)) return false;

        CardKeyword that = (CardKeyword) o;

        return this.getStem().equals(that.getStem());
    }

    // ----- getters, setters

    public String getStem() {
        return this.stem;
    }

    public Set<String> getTerms() {
        return this.terms;
    }

    public int getFrequency() {
        return this.frequency;
    }
}
