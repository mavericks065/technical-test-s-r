import checkAllDigitsArePresent from "./logic";

describe("logical exercise 1", () => {
  describe("when receiving a number the function checkAllDigitsArePresent", () => {
    it("should return false if not all digits are present", () => {
      // Given
      const longNumber = 9864523148090;

      // When
      const result = checkAllDigitsArePresent(longNumber);

      // Then
      expect(result).toBe(false);
    });
    it("should return true if all digits are present", () => {
      // Given
      const longNumber = 98410783562910;

      // When
      const result = checkAllDigitsArePresent(longNumber);

      // Then
      expect(result).toBe(true);
    });
  });
});
