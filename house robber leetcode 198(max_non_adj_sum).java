// # 198.House Robber

// # maximum sum of non adjacent  elements


// # 5   3   2   4   2   4


// # 5 + 4 + 4 = 13 


// # brute force:
// # get all combinations

// # 5 ---->  2   4   2   4


// # 5    2 ---->   2   4


// # 5    2    2 ----> 


// # 5    2    4 ---->


// # 5    4   ---->  2    4


// # 5    4    4  ----> 

// # how to code this:
// # 2 for loop-> we cat use it
// # select 5 then skip 3
// # select any of  2   4   2   4(recursion)

// # 5 2 skip 4  select any of  2   4


    


// def max_non_adjacent_sum(arr):
//     max_sum = 0
    
//     # Outer loop to pick the first element of the subset
//     for i in range(len(arr)):
//         current_sum = arr[i]
        
//         # Inner loop to pick subsequent elements with a gap of at least one
//         for j in range(i + 2, len(arr), 1):
//             current_sum += arr[j]
//             max_sum = max(max_sum, current_sum)
//             # Remove last added element to try the next possible subset
//             current_sum -= arr[j]
            
//     return max_sum

// # Example usage
// arr = [5, 3, 2, 4, 2, 4]
// print(max_non_adjacent_sum(arr))  # Output should be 13



// # now try to convert this to recursion


// def max_non_adjacent_sum(arr,arrIndex,current_sum,max_sum):
//     if arrIndex>len(arr):
//         return
        
//     max_sum = max(max_sum, current_sum)
//     current_sum+=arr[arrIndex]
//     max_non_adjacent_sum(arr,arrIndex+2,current_sum,max_sum)
//     current_sum-=arr[arrIndex]


// def max_non_adjacent_sum(arr, arrIndex=0, current_sum=0):
//     # Base case: if arrIndex exceeds array bounds, return current_sum
//     if arrIndex >= len(arr):
//         return current_sum
    
//     # Recursive case 1: Include current element and move to arrIndex + 2
//     include_sum = max_non_adjacent_sum(arr, arrIndex + 2, current_sum + arr[arrIndex])
    
//     # Recursive case 2: Exclude current element and move to arrIndex + 1
//     exclude_sum = max_non_adjacent_sum(arr, arrIndex + 1, current_sum)
    
//     # Return the maximum of both choices
//     return max(include_sum, exclude_sum)

// # Example usage
// arr = [5, 3, 2, 4, 2, 4]
// print(max_non_adjacent_sum(arr))  # Output should be 13



// # till this i need code in java and c++



// def max_non_adjacent_sum(arr):
//     max_sum = 0
    
//     # Outer loop to pick the first element of the subset
//     for i in range(len(arr)):
//         current_sum = arr[i]
        
//         # Inner loop to pick subsequent elements with a gap of at least one
//         for j in range(i + 2, len(arr), 1):
//             current_sum += arr[j]
//             max_sum = max(max_sum, current_sum)
//             # Remove last added element to try the next possible subset
//             current_sum -= arr[j]
            
//     return max_sum


public void max_non_adjacent_sum(int arr[]){
    int max_sum=0;
    for(int i=0;i<arr.length();i++){
        current_sum=arr[i];
        for(int j=i+2;j<arr.length();i++){
            current_sum += arr[j];
            max_sum = max(max_sum, current_sum);
            current_sum -= arr[j];
        }
    }
    return max_sum;
}


public int maxNonAdjacentSum(int[] arr) {
    int maxSum = 0;
    
    // Outer loop to pick the first element of the subset
    for (int i = 0; i < arr.length; i++) {
        int currentSum = arr[i];
        
        // Inner loop to pick subsequent elements with a gap of at least one
        for (int j = i + 2; j < arr.length; j++) {
            currentSum += arr[j];
            maxSum = Math.max(maxSum, currentSum);
            
            // Remove the last added element to try the next possible subset
            currentSum -= arr[j];
        }
    }
    
    return maxSum;
}


// def max_non_adjacent_sum(arr, arrIndex=0, current_sum=0):
//     # Base case: if arrIndex exceeds array bounds, return current_sum
//     if arrIndex >= len(arr):
//         return current_sum
    
//     # Recursive case 1: Include current element and move to arrIndex + 2
//     include_sum = max_non_adjacent_sum(arr, arrIndex + 2, current_sum + arr[arrIndex])
    
//     # Recursive case 2: Exclude current element and move to arrIndex + 1
//     exclude_sum = max_non_adjacent_sum(arr, arrIndex + 1, current_sum)
    
//     # Return the maximum of both choices
//     return max(include_sum, exclude_sum)


public int max_non_adjacent_sum(int[] arr,int arrIndex=0,current_sum=0){
    if(arrIndex>=arr.length){
        return current_sum
    }
}