class CountConsistent {
    countConsistentStrings(allowed, words) {
        const allowedSet = new Set(allowed);
        let count = 0;

        for (const word of words) {
            for (const c of word) {
                if (!allowedSet.has(c)) {
                    count++;
                    break;
                }
            }
        }

        return words.length - count;
    }
}

console.log(CountConsistent.countConsistentStrings("ab", ["ad", "bd", "aaab", "baa", "badab"]));