import kotlin.math.max

class FuelCalculator {
    fun calculateBasicFuelRequired(weights: List<Int>): Int {
        return weights
            .map { it / 3 }
            .map { it - 2 }
            .sum()
    }

    fun calculateAdvancedFuelRequired(weights: List<Int>): Int {
        return weights
            .map { calculateFuel(it) }
            .map { calculateModuleFuel(it) }
            .sum()
    }

    private fun calculateModuleFuel(weight: Int): Int {
        var moduleWeight = weight;
        var fuelWeight = weight;
        do {
            fuelWeight = calculateFuel(fuelWeight)
            moduleWeight += fuelWeight
        }while (fuelWeight > 0)
        return moduleWeight;
    }

    private fun calculateFuel(weight: Int) = max((weight / 3) - 2, 0)
}
