import areLettersOrdered from "./logic_2";

describe("logical exercise 2, when receiving an array of letters", () => {
  describe("areLettersOrdered ", () => {
    it("should return an empty string if letters are ordered", () => {
      // Given
      const letters = ['a', 'b', 'c'];

      // When
      const result = areLettersOrdered(letters);

      // Then
      expect(result).toBe('');
    });
    it("should return the missing letter if letters are not ordered", () => {
      // Given
      const letters = ['a', 'b', 'd'];
      const letters1 = ['v', 'x'];

      // When
      const result = areLettersOrdered(letters);
      const result1 = areLettersOrdered(letters1);

      // Then
      expect(result).toBe('c');
      expect(result1).toBe('w');
    });
  });
});
