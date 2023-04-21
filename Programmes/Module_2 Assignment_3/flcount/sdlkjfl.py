import numpy as np

# function to solve the advertising allocation problem using dynamic programming


def advertisingAllocationProblem(budget, fb_cost, fb_conv_rate, insta_cost, insta_conv_rate):

    # calculate the number of remaining ads for each platform at each state
    fb_ads = np.arange(0, budget//fb_cost + 1)
    insta_ads = np.arange(0, budget//insta_cost + 1)

    # create a grid to store the expected profits for each state
    profit_grid = np.zeros((len(fb_ads), len(insta_ads)))

    # fill in the grid using dynamic programming
    for fb_idx, fb_ad in enumerate(fb_ads):
        for insta_idx, insta_ad in enumerate(insta_ads):

            # calculate the total number of ads placed and remaining budget
            total_ads = fb_ad + insta_ad
            remaining_budget = budget - \
                (fb_ad * fb_cost + insta_ad * insta_cost)

            # calculate the expected profit at this state
            fb_profit = fb_ad * fb_conv_rate * remaining_budget
            insta_profit = insta_ad * insta_conv_rate * remaining_budget
            expected_profit = fb_profit + insta_profit

            # update the profit grid
            if total_ads == 0:
                profit_grid[fb_idx, insta_idx] = 0
            elif remaining_budget < 0:
                profit_grid[fb_idx, insta_idx] = -np.inf
            else:
                profit_grid[fb_idx, insta_idx] = expected_profit + \
                    np.max(profit_grid[:fb_idx+1, :insta_idx+1])

    # find the optimal allocation of budget
    fb_idx, insta_idx = np.unravel_index(
        np.argmax(profit_grid), profit_grid.shape)
    fb_ad = fb_ads[fb_idx]
    insta_ad = insta_ads[insta_idx]
    optimal_profit = profit_grid[fb_idx, insta_idx]

    # return the optimal allocation and the maximum profit
    return fb_ad, insta_ad, optimal_profit


# get input from the user
budget = float(input("Enter the budget: "))
fb_cost = float(input("Enter the cost per Facebook ad: "))
fb_conv_rate = float(input("Enter the conversion rate for Facebook: "))
insta_cost = float(input("Enter the cost per Instagram ad: "))
insta_conv_rate = float(input("Enter the conversion rate for Instagram: "))

# solve the problem using dynamic programming
fb_ad, insta_ad, optimal_profit = advertisingAllocationProblem(
    budget, fb_cost, fb_conv_rate, insta_cost, insta_conv_rate)

# print the optimal allocation and the maximum profit
print("The optimal allocation of budget is:")
print("Facebook ads: ", fb_ad)
print("Instagram ads: ", insta_ad)
print("The maximum expected profit is: ", optimal_profit)
