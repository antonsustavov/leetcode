package com.sustav.ALGORITHM.challenges.algoexpert.easy.generate_document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenerateDocumentTest {
    private GenerateDocument generateDocument;

    @BeforeEach
    void setUp() {
        generateDocument = new GenerateDocument();
    }

    @Test
    void generateDocument() {
        var characters = "Bste!hetsi ogEAxpelrt x ";
        var document = "AlgoExpert is the Best!";

        var actual = generateDocument.generateDocument2(characters, document);

        assertThat(actual).isTrue();
    }

    @Test
    void generateDocument2() {
        var characters = "     ";
        var document = "     ";

        var actual = generateDocument.generateDocument2(characters, document);

        assertThat(actual).isTrue();
    }

    @Test
    void generateDocument3() {
        var characters = "A";
        var document = "a";

        var actual = generateDocument.generateDocument2(characters, document);

        assertThat(actual).isFalse();
    }
}