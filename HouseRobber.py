# 198.House Robber

# maximum sum of non adjacent  elements


# 5   3   2   4   2   4


# 5 + 4 + 4 = 13 


# brute force:
# get all combinations

# 5 ---->  2   4   2   4


# 5    2 ---->   2   4


# 5    2    2 ----> 


# 5    2    4 ---->


# 5    4   ---->  2    4


# 5    4    4  ----> 

# how to code this:
# 2 for loop-> we cat use it
# select 5 then skip 3
# select any of  2   4   2   4(recursion)

# 5 2 skip 4  select any of  2   4



# now try to convert this to recursion


# def max_non_adjacent_sum(arr,arrIndex,current_sum,max_sum):
#     if arrIndex>len(arr):
#         return
        
#     max_sum = max(max_sum, current_sum)
#     current_sum+=arr[arrIndex]
#     max_non_adjacent_sum(arr,arrIndex+2,current_sum,max_sum)
#     current_sum-=arr[arrIndex]


# def max_non_adjacent_sum_for_loop(arr):
#     max_sum = 0
    
#     # Outer loop to pick the first element of the subset
#     for i in range(len(arr)):
#         current_sum = arr[i]
        
#         # Inner loop to pick subsequent elements with a gap of at least one
#         for j in range(i + 2, len(arr), 1):
#             current_sum += arr[j]
#             max_sum = max(max_sum, current_sum)
#             # Remove last added element to try the next possible subset
#             current_sum -= arr[j]
            
#     return max_sum

# # Example usage
# arr = [5, 3, 2, 4, 2, 4]
# print(max_non_adjacent_sum_for_loop(arr))  # Output should be 13





# def max_non_adjacent_sum_recursion(arr, arrIndex=0, current_sum=0):
#     # Base case: if arrIndex exceeds array bounds, return current_sum
#     if arrIndex >= len(arr):
#         return current_sum
    
#     # Recursive case 1: Include current element and move to arrIndex + 2
#     include_sum = max_non_adjacent_sum_recursion(arr, arrIndex + 2, current_sum + arr[arrIndex])
    
#     # Recursive case 2: Exclude current element and move to arrIndex + 1
#     exclude_sum = max_non_adjacent_sum_recursion(arr, arrIndex + 1, current_sum)
    
#     # Return the maximum of both choices
#     return max(include_sum, exclude_sum)

# # Example usage
# arr = [5, 3, 2, 4, 2, 4]
# print(max_non_adjacent_sum_recursion(arr))  # Output should be 13

#  Maximum Sum of Non-Adjacent Elements


# def max_non_adjacent_sum_dynamic_programming(arr):
#     rob1,rob2=0,0
#     for n in nums:
#         temp=max(n+rob1,rob2)
#         rob1=rob2
#         rob2=temp
#     return rob2

# Brute Force with Loops
def max_non_adjacent_sum_for_loop(arr):
    max_sum = 0
    
    # Outer loop to pick the first element of the subset
    for i in range(len(arr)):
        current_sum = arr[i]
        
        # Inner loop to pick subsequent elements with a gap of at least one
        for j in range(i + 2, len(arr)):
            current_sum += arr[j]
            max_sum = max(max_sum, current_sum)
            
            # Undo the last addition to try the next possible subset
            current_sum -= arr[j]
            
    return max_sum

# Example usage
arr = [5, 3, 2, 4, 2, 4]
print("Max sum (brute force loop):", max_non_adjacent_sum_for_loop(arr))  # Output should be 13


# Recursive Solution with Explicit Choices
def max_non_adjacent_sum_recursion(arr, arrIndex=0):
    # Base case: if arrIndex exceeds array bounds, no elements to add
    if arrIndex >= len(arr):
        return 0
    
    # Recursive case 1: Include current element and move to arrIndex + 2
    include_sum = arr[arrIndex] + max_non_adjacent_sum_recursion(arr, arrIndex + 2)
    
    # Recursive case 2: Exclude current element and move to arrIndex + 1
    exclude_sum = max_non_adjacent_sum_recursion(arr, arrIndex + 1)
    
    # Return the maximum of both choices
    return max(include_sum, exclude_sum)

# Example usage
print("Max sum (recursion):", max_non_adjacent_sum_recursion(arr))  # Output should be 13


# Optimized Dynamic Programming Solution
def max_non_adjacent_sum_dynamic_programming(arr):
    rob_prev1, rob_prev2 = 0, 0
    
    # Iterate through each element to calculate max sum up to each point
    for n in arr:
        new_rob = max(n + rob_prev1, rob_prev2)
        rob_prev1 = rob_prev2
        rob_prev2 = new_rob
    
    return rob_prev2

# Example usage
print("Max sum (dynamic programming):", max_non_adjacent_sum_dynamic_programming(arr))  # Output should be 13


def max_non_adjacent_sum_tabulation(arr):
    # Edge cases: empty array or single element array
    if not arr:
        return 0
    elif len(arr) == 1:
        return arr[0]

    # Initialize DP table with the length of the array
    dp = [0] * len(arr)
    
    # Base cases
    dp[0] = arr[0]
    dp[1] = max(arr[0], arr[1])

    # Fill the DP table by iterating through the array
    for i in range(2, len(arr)):
        dp[i] = max(arr[i] + dp[i - 2], dp[i - 1])
    
    # The last element in dp array holds the result
    return dp[-1]

# Example usage
arr = [5, 3, 2, 4, 2, 4]
print("Max non-adjacent sum (tabulation):", max_non_adjacent_sum_tabulation(arr))  # Output should be 13
