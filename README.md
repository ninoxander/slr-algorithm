# 🖥️ Simple Linear Regression 🖥️
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

This is a work-in-progress implementation of the Simple Linear Regression algorithm, created for a task in the Simulation class at Tecnológico Superior de Zapopan.


## Approach

Implementing JADE agent through OOP classes to set the SLR algorithm running.

# Sales Data Analysis Using Simple Linear Regression (SLR)

This project involves the analysis of sales data to understand the relationship between advertising spending and sales figures. The analysis is performed using Simple Linear Regression (SLR) to predict future sales based on historical data.

## Original Sales Data

The original sales data consists of advertising spending and the corresponding sales figures. This dataset serves as the foundation for our analysis and helps to establish a baseline relationship.

### Original Sales Data Table

| **Advertising Spend ($)** | **Sales ($)** |
|---------------------------|----------------|
| 23                        | 651            |
| 26                        | 762            |
| 30                        | 856            |
| 34                        | 1063           |
| 43                        | 1190           |
| 48                        | 1298           |
| 52                        | 1421           |
| 57                        | 1440           |
| 58                        | 1518           |

The above table outlines the relationship between advertising spend and sales. Each row represents a specific data point where advertising spending in dollars is correlated with sales achieved.


Regarding this sales data set, values of _**beta 0, beta 1, beta 0 standard error, beta 1 standard error,
r squared and r correlation**_ are:

| **B0​**   | **B1**    | **B0 SE** | **B1 SE**  | **R Squared** | **R Correlation** |
| --------- | --------- | --------- | ---------- | ------------- | ----------------- |
| 167.68292 | 23.422785 | 22.276848 | 0.51667094 | 0.9979556     | 0.9989773         |


Using a different set of x values, the forecast prediction data are:

| X     | Forecast ($) |
|-------|--------------|
| 55.0  | ≈ 1455.936   |
| 60.0  | ≈ 1573.05    |
| 65.0  | ≈ 1690.1638  |
| 125.0 | ≈ 3095.531   |
| 340.0 | ≈ 8131.43    |
| 1200.0| ≈ 28275.025  |
### Graph of Original Sales Data

![Original Sales Data](https://i.ibb.co/XYm2WXm/originaldatagraph.png)

The graph visually represents the original sales data with points indicating actual sales figures against advertising spending. The red line shows the regression line, which is derived from the data points and represents the predicted relationship between advertising spend and sales.

## Forecast Sales Data

In addition to analyzing the original sales data, we also developed forecasts based on predicted advertising spend values. The forecast helps to project future sales and assess the impact of increased advertising investment.


This table displays the predicted sales figures based on various levels of advertising spending using the established regression model.

### Graph of Forecast Sales Data

![Forecast Sales Data](https://i.ibb.co/cCKzx0v/forecastadatagraph.png)

The graph illustrates the forecasted sales data, including points representing the forecasted values. The red line indicates the regression line based on the forecast data, illustrating the expected trend as advertising spending increases.

## Conclusion

Through this analysis, we have successfully demonstrated the relationship between advertising spending and sales figures using Simple Linear Regression.


## TODO

* ✅ To separate mathematic functions into another file.
* ✅ Add functions for error fitting.
* Create more documentation.