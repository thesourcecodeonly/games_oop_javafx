package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int x = position.getX();
        int y = position.getY();
        int deltaX = x - dest.getX();
        int deltaY = y - dest.getY();
        int size = (Math.abs(deltaX));
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            x += 1;
            y -= 1;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int deltaX = source.getX() - dest.getX();
        int deltaY = source.getY() - dest.getY();
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public static void main(String[] args) {

        BishopBlack bishopBlack = new BishopBlack(Cell.A1);

        System.out.println(Arrays.toString(bishopBlack.way(Cell.G5)));

    }
}
