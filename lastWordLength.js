/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
  s = s.trim();
  return s.substring(s.lastIndexOf(" ")+1).length;
};

console.log(lengthOfLastWord("   fly me   to   the moon  "));

