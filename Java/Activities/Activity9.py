lst1 = [10, 15, 23, 42, 37, 51]
lst2 = [8, 13, 20, 33, 40, 55]

def combine_odd_first_even_second(list1, list2):

    odd_from_first = [x for x in list1 if x % 2 != 0]
  
    even_from_second = [x for x in list2 if x % 2 == 0]

    return odd_from_first + even_from_second



new_list = combine_odd_first_even_second(lst1, lst2)
print(new_list)  # Output: [15, 23, 37, 51, 8, 20, 40]
