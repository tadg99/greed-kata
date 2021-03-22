(function() {
    "use strict";  
    window.addEventListener("load", init);
  
    /**
     * 
     */
    function init() {
        id("bestButton").addEventListener("click", updateScore);
    }

    function updateScore() {
        id("bestLabel").innerText = "Best Score: " + getBestScore();
    }

    function getBestScore() {
        let counts = new Map();
        for (let i = 1; i <= 6; i++) {
            counts.set("" + i, 0);
        }
        counts.set(id("die1").value, counts.get(id("die1").value) + 1);
        counts.set(id("die2").value, counts.get(id("die2").value) + 1);
        counts.set(id("die3").value, counts.get(id("die3").value) + 1);
        counts.set(id("die4").value, counts.get(id("die4").value) + 1);
        counts.set(id("die5").value, counts.get(id("die5").value) + 1);

        let best = 0;
        if (counts.get("1") >= 3) {
            best += 1000 + (100 * (counts.get("1") - 3)); //1000 for triple 1s plus 100 for each of the remaining 1s
            return best + (counts.get("5") * 50); //Can return here because only other points come from 5s
        }
        best += counts.get("1") * 100;
        for (let i = 2; i <= 6; i++) {
            if (i == 5) {
                best += (counts.get("5") % 3) * 50;
            }
            if (counts.get("" + i) >= 3) {
                best += i * 100;
            }
        }
        return best;
    }

    /**
     * Returns the element that has the ID attribute with the specified value.
     * @param {string} idName - element ID
     * @returns {object} DOM object associated with id.
     */
    function id(idName) {
        return document.getElementById(idName);
    }
  })();