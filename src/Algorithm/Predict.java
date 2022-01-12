package Algorithm;

/**
 *Design an API to find files subject to the following predicates:
 * * Size greater than x.
 * * Filename/extension ending in y.
 * * Logical operators AND/OR on the other predicates
 * Design the API to be extensible to additional predicates in the future.
 *
 * Meets Expectations:
 * * Identifies common interface to all predicates using Composite pattern or similar with little or no assistance
 * * Adding new predicates does not require special cases or if/else statements
 * * Writes 4 concrete implementations of the implementation:
 *     * Algorithm.File size > x
 *     * Filename ending in y
 *     * AND operator
 *     * OR operator
 *

 **/


interface Predicate {
    boolean matches(File file);
}

class AndPredicate implements Predicate {
    private Predicate left;
    private Predicate right;
    public AndPredicate(Predicate left, Predicate right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean matches(File file) {
        return left.matches(file) && right.matches(file);
    }
}

class OrPredicate implements Predicate {
    private Predicate left;
    private Predicate right;
    public OrPredicate(Predicate left, Predicate right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean matches(File file) {
        return left.matches(file) || right.matches(file);
    }
}

class FileExtentionPredicate implements Predicate {
    private String extension;
    public FileExtentionPredicate(String extension){
        this.extension = extension;
    }
    @Override
    public boolean matches(File file) {
        return file.getFileName().endsWith(extension);
    }
}

class MinSizePredicate implements Predicate {
    private int minSize;
    public MinSizePredicate(int size){
        this.minSize = size;
    }
    @Override
    public boolean matches(File file) {
        return file.getSize() > minSize;

    }
}

class File {
    private String fileName;
    private int size;
    public File(String fileName, int size){
        this.fileName = fileName;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getFileName() {
        return fileName;
    }
}