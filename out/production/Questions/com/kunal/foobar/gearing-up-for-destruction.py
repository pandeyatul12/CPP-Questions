from fractions import Fraction
def solution(pegs):
    base = [-1, -1]
    n = len(pegs)

    if n <= 1:
        return base

    if n % 2 == 0:
        sumP = -pegs[0] + pegs[n - 1]
    else:
        sumP = - pegs[0] - pegs[n - 1]

    for i in range(1, n - 1):
        sumP += 2 * pegs[i] * (-1) ** (i + 1)

    if n % 2 == 1:
        firstR = Fraction(2 * sumP).limit_denominator()
    else:
        firstR = Fraction(2 * sumP / 3.0).limit_denominator()

    if firstR < 2:
        return base

    current = firstR

    for i in range(0, n - 2):
        center = pegs[i + 1] - pegs[i]
        nextR = center - current

        if current >= 1 and nextR >= 1:
            current = nextR
        else:
            return base

    num = firstR.numerator
    den = firstR.denominator

    return [num, den]
