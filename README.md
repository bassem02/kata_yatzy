This kata was refactored by Bassem BEN AMAR

- Test class refactoring: 
  - Junit 5 is used instead of Junit 4.
  - ParameterizedTest is used to have more flexibility to test any dice combination.

- Algorithm logic refactoring:
  - The algorithm logic was refactored using API steam, which is a better way to handle list operation like filtering and summing.
  - The ListUtils class is used to share the common list operations using stream.

- Design pattern:
  - Strategy:
    As we have different algorithms to compute score for each category, strategy design pattern seems to be the settable pattern to be used.

  - Factory:
    As we need to create a new strategy class for each category to pass it as parameter in Yatzy class, factory design pattern is used to reduce this complexity.
