package wordcounter;

import wordcounter.exception.NotFoundException;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Sergiy on 16.10.2016.
 */
public class WordCounter {
    private static final Map<String, Long> repository;

    static {
        repository = new ConcurrentHashMap();
    }

    public Long putWord(java.lang.String word) {
        Objects.requireNonNull(word);
        String wrap = wrap(word);
        Long value = repository.get(wrap);

        if (value == null) {
            repository.put(wrap, 1L);
            return 1L;
        } else {
            repository.put(wrap, ++value);
            return value;
        }
    }

    public Long getCountOfWord(java.lang.String word) throws NotFoundException {
        Long value = repository.get(wrap(word));
        if (value == null) throw new NotFoundException(
                java.lang.String.format("No such word - %s", word));

        return value;
    }

    public Long deleteWord(java.lang.String word) throws NotFoundException {
        Long removed = repository.remove(wrap(word));

        if (removed == null) throw new NotFoundException(
                java.lang.String.format("No such word - %s", word));

        return removed;
    }

    public void deleteAllWords() {
        repository.clear();
    }

    public void printAll() {
        repository.entrySet().forEach(System.out::println);
    }

    private String wrap(java.lang.String wrappingValue) {
        return new String(wrappingValue);
    }

    private static class String implements Comparable<String>, Serializable {
        private final java.lang.String wrappedString;

        public String(java.lang.String string) {
            this.wrappedString = string;
        }

        public java.lang.String getWrappedString() {
            return wrappedString;
        }

        public int compareTo(String o) {
            return this.wrappedString.compareToIgnoreCase(o.getWrappedString());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            String string = (String) o;

            return wrappedString != null ?
                    wrappedString.equalsIgnoreCase(string.wrappedString) : string.wrappedString == null;
        }

        @Override
        public int hashCode() {
            return wrappedString != null ? wrappedString.toLowerCase().hashCode() : 0;
        }

        @Override
        public java.lang.String toString() {
            return wrappedString;
        }
    }
}
