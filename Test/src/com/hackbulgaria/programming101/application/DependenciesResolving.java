package com.hackbulgaria.programming101.application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DependenciesResolving {

    public static Set<String> packageManager(Map<String, List<String>> allPackages, List<String> dependencies,
            Set<String> installedModules) {

        Stack<String> packages = new Stack<String>();
                
        for (String dependancy : dependencies) {
            if (!installedModules.contains(dependancy)) {
                installedModules.add(dependancy);
                for (String packageOfDependancy : allPackages.get(dependancy)) {
                    if (!installedModules.contains(packageOfDependancy)) {
                    packages.push(packageOfDependancy);
                    installedModules.add(packageOfDependancy);
                    }
                }
            }
        }
        
        while (packages.size() != 0) {
            String temporaryDependancy = packages.pop();
            if (allPackages.get(temporaryDependancy).size() != 0) {
                for (String subPackage : allPackages.get(temporaryDependancy)) {
                    if (!installedModules.contains(subPackage)) {
                    packages.push(subPackage);
                    installedModules.add(subPackage);
                    }
                }
            }
        }
        return installedModules;
    }

    public static void main(String[] args) {
        
        Map<String, List<String>> allPackages = new HashMap<String, List<String>>();
        List<String> dependencies = new LinkedList<String>();
        Set<String> installedModules = new HashSet<String>();

        List<String> allPackagesFirstValue = new LinkedList<String>();
        List<String> allPackagesSecondValue = new LinkedList<String>();
        List<String> allPackagesThirdValue = new LinkedList<String>();
        List<String> allPackagesForthValue = new LinkedList<String>();
        List<String> allPackagesfifthValue = new LinkedList<String>();
        
        allPackagesFirstValue.add("jQuery");
        allPackagesFirstValue.add("underscore");
        allPackagesSecondValue.add("queryJ");
        allPackagesThirdValue.add("lodash");
        
        
        allPackages.put("backbone", allPackagesFirstValue);
        allPackages.put("jQuery", allPackagesSecondValue);
        allPackages.put("underscore", allPackagesThirdValue);
        allPackages.put("queryJ", allPackagesForthValue);
        allPackages.put("lodash", allPackagesfifthValue);
        
        dependencies.add("backbone");

        installedModules.add("lodash");

        System.out.println(packageManager(allPackages, dependencies, installedModules));

    }

}
