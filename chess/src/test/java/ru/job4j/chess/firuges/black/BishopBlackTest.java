package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionMethodReturnCell() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.A1);
    }

    @Test
    void whenCopyMethodReturnDest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.copy(Cell.D4).position()).isEqualTo(Cell.D4);
    }

    @Test
    void whenWayMethodShowCellsIsTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(Arrays.toString(bishopBlack.way(Cell.G5))).isEqualTo("[D2, E3, F4, G5]");
    }

    @Test
    void whenWayMethodShowCellsIsImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
           bishopBlack.way(Cell.G5);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from A1 to G5.");
    }
}