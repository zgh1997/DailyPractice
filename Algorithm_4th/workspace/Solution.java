public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int medianLen = (nums1.length + nums2.length) / 2;
        medianLen= (nums1.length + nums2.length) % 2 == 1? medianLen : medianLen - 1;
        int i = nums1.length / 2;
        int j = medianLen  - i;
        int times = 4;
        while (2*nums1.length / times > 0) {
        	if (nums1[i] == nums2[j]) {
        		break;
        	}else if (nums1[i] > nums2[j]) {
                j += nums1.length / times + 1;
                i = medianLen  - j;
            }else {
                i += nums1.length / times + 1;
                j = medianLen  - i;
            }
            times = times * 2;
            if (i < 0) {
            	i = 0;
            	j = medianLen;
            	break;
            } else if (i >= nums1.length) {
            	i = nums1.length - 1;
            	j = medianLen - nums1.length;
            	break;
            }
            System.out.println("i: " + i + "  j: " + j + " delta:" + (double)(nums1.length / times));
        }
        System.out.println("Index1: " + i + "  Nums: " + nums1[i]);
        System.out.println("Index2: " + j + "  Nums: " + nums2[j]);
        if ((nums1.length + nums2.length) % 2 == 1) {
        	if ((i == nums1.length - 1) && i < (nums1.length + nums2.length) - 1) {
        		return nums2[medianLen - i - 1];
        	} else if(i == 0 && nums1[i] > nums2[j]) {
        		return nums2[medianLen - i];
        	} else {
        		return Math.min(nums1[i], nums2[j]);
        	}
        } else {
        	if ((i == nums1.length - 1) && i < medianLen) {
        		return (double)(nums2[medianLen - i]
        						+ nums2[medianLen - i - 1]) / 2;
        	} else if(i == 0 && nums1[i] > nums2[j]){
        		return (double)(nums2[medianLen - i - 1]
						+ nums2[medianLen - i]) / 2;
        	} else {
        		return (double)(nums1[i] + nums2[j]) / 2;
        	}
        }
    }

    public static void main(String[] args) {
//    	int[] nums1 = {0,1,2,3,4,5,6,7,8,9,10, 12, 14,22,23,99,111};
//    	int[] nums2 = {95,100,101,102,103,104,105,106,107,108};
//    	int[] nums1 = {0,1,2,3,4,5,6,7,8,9,10};
//    	int[] nums2 = { 0,1,2,3,4,5,6,7,8,9,10,24, 26,30,31,32,33,34, 36, 39, 42, 45, 48, 51, 54};
//    	int[] nums1 = {2,4,6,12,14,30,31,32};
//    	int[] nums2 = {2,4,6,12,14,30,31,45, 48, 51, 54, 57};
//    	int[] nums1 = {2,4,6,12,14,20,21,22};
//    	int[] nums2 = {30,33, 51, 54, 57,58,59,77};
//    	int[] nums1 = {14,15,16,17,18,19,20,21};
//    	int[] nums2 = {1,2,3,4,5,6,7,8,9};
    	int[] nums1 = {2,4};
    	int[] nums2 = {1,3};
    	double result = findMedianSortedArrays(nums1, nums2);
    	System.out.println("Result :  "+ result);


    	System.out.print("\nNums1: ");
    	for (int x1 = 0; x1 < nums1.length; x1 ++) {
    		System.out.print(nums1[x1] + ", ");
    	}
    	System.out.print("\nNums2: ");
    	for (int x2 = 0; x2 < nums2.length; x2 ++) {
    		System.out.print(nums2[x2] + ", ");
    	}
    	int i = 0, j = 0;
    	int str[] = new int[nums1.length + nums2.length];
    	while (i < nums1.length || j < nums2.length) {
    		if (i == nums1.length) {
    			str[i + j] = nums2[j];
    			j ++;
    			continue;
    		}else if (j == nums2.length) {
    			str[i + j] = nums1[i];
    			i ++;
    			continue;
    		}else {
    			if (nums1[i] >= nums2[j]) {
    				str[i + j] = nums2[j];
    				j ++;
    			}else {
    				str[i + j] = nums1[i];
    				i ++;
    			}
    		}
    	}
    	System.out.println("\nSorted Array:");
    	if (str.length % 2 == 1) {
	    	for (int x = 0; x < str.length; x ++) {
	    		if (x == str.length / 2) {
	    			System.out.print(" Median:"+ str[x]+", ");
	    			continue;
	    		}
	    		System.out.print(str[x]+", ");
	    	}
    	} else {
    		for (int x = 0; x < str.length; x ++) {
	    		if (x == str.length / 2 - 1 || x == str.length / 2) {
	    			System.out.print(" Median:"+ str[x]+", ");
	    			continue;
	    		}
	    		System.out.print(str[x]+", ");
	    	}
    	}

    }
}
