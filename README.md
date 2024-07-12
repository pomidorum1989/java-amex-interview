# Problem Description: Credit Card Validation using Java

## Problem Statement

You are tasked with implementing a Java program `CreditCardParser` that validates credit card numbers based on predefined criteria. The program should be able to:

1. Identify and validate three types of credit cards: AMEX, Mastercard, and Visa, based on their initial digits.
2. Validate the format and expiration date of the credit card number input.
3. Implement the Luhn algorithm to verify the authenticity of the credit card number.
4. Provide methods to both validate a given credit card number string and interactively accept input from the user.

## Requirements

### Card Types

- **AMEX**: Identified by numbers starting with `1121`.
- **Mastercard**: Identified by numbers starting with `1111`.
- **Visa**: Identified by numbers starting with `3796`.

### Validation Criteria

- The credit card number must be in the format `xxxx-xxxx-xxxx-xxxx`, where each `x` represents a digit.
- The expiration date of the card (extracted from the input) should be validated to ensure it is not expired.
- Only numeric digits (excluding hyphens) should be considered valid.
- The program should print appropriate messages indicating whether a credit card number is valid or invalid based on the criteria.