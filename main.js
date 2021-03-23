/**
 * Script file for a basic high score calculator for a 5 dice greed-kata game
 */
(function() {
    "use strict";  
    window.addEventListener("load", init);
  
    /**
     * Adds a click event listen to the 'Get Best Score' button
     */
    function init() {
        id("bestButton").addEventListener("click", updateScore);
    }

    /**
     * Updates the text on the page to reflect the best score of the current roll
     */
    function updateScore() {
        id("bestLabel").innerText = "Best Score: " + getBestScore();
    }

    /**
     * Calculates the best (highest) score of the given roll. Returns a number representing the
     * best possible score.
     * @returns {number} The best score of the given roll
     */
    function getBestScore() {
        let counts = new Map();
        for (let i = 1; i <= 6; i++) {
            counts.set("" + i, 0); //Initalize the map with counts of 0 for die values 1-6
        }
        //Fill the map with the values of the dice.
        counts.set(id("die1").value, counts.get(id("die1").value) + 1);
        counts.set(id("die2").value, counts.get(id("die2").value) + 1);
        counts.set(id("die3").value, counts.get(id("die3").value) + 1);
        counts.set(id("die4").value, counts.get(id("die4").value) + 1);
        counts.set(id("die5").value, counts.get(id("die5").value) + 1);

        let best = 0;
        if (counts.get("1") >= 3) {
            best += 1000 + (100 * (counts.get("1") - 3)); //1000 for triple 1s plus 100 for each of the remaining 1s
            return best + (counts.get("5") * 50); //return here because only other points come from 5s
        }
        best += counts.get("1") * 100; //account for single 1s
        //Check for triples of 2-5
        for (let i = 2; i <= 6; i++) {
            if (i == 5) {
                //special case for single 5s
                best += (counts.get("5") % 3) * 50;
            }
            if (counts.get("" + i) >= 3) {
                best += i * 100;
            }
        }
        return best;
    }

    /**
     * Helper method that returns the element that has the ID attribute with the specified value.
     * @param {string} idName - element ID
     * @returns {object} DOM object associated with id.
     */
    function id(idName) {
        return document.getElementById(idName);
    }
  })();