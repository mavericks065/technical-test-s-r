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
    it("should return empty if array is null, undefined or empty", () => {
      // Given
      const letters = null;
      const letters1 = undefined;
      const letters2 = [];

      // When
      const result = areLettersOrdered(letters);
      const result1 = areLettersOrdered(letters1);
      const result2 = areLettersOrdered(letters2);

      // Then
      expect(result).toBe('');
      expect(result1).toBe('');
      expect(result2).toBe('');
    });
  });
});
