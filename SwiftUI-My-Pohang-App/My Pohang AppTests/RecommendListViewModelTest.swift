//
//  My_Pohang_AppTests.swift
//  My Pohang AppTests
//
//  Created by Jaehwa Noh on 12/23/23.
//

import XCTest
@testable import My_Pohang_App

final class RecommendListViewModelTest: XCTestCase {
    
    private var recommendListViewModel: RecommendListViewModel?
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        self.recommendListViewModel = RecommendListViewModel()
    }
    
    override func tearDownWithError() throws {
        try super.tearDownWithError()
        self.recommendListViewModel = nil
    }
    
    func test_RecommendListViewModel_SelectCategory_SetCategorySuccess() {
        recommendListViewModel?.setSelectedCategory(category: CategoryAndRecommendRepository().categories[0])
        XCTAssertNotNil(recommendListViewModel?.selectedCategory)
        XCTAssertEqual(recommendListViewModel?.selectedCategory, CategoryAndRecommendRepository().categories[0])
    }
    
    func test_RecommendListViewModel_SelectCategory_SetCategoryFail() {
        recommendListViewModel?.setSelectedCategory(category: CategoryAndRecommendRepository().categories[1])
        XCTAssertNotNil(recommendListViewModel?.selectedCategory)
        XCTAssertNotEqual(recommendListViewModel?.selectedCategory, CategoryAndRecommendRepository().categories[0])
    }
    
    func test_RecommendListViewModel_SelectCategory_SetCategoryEdge() {
        CategoryAndRecommendRepository().categories.forEach { category in
            recommendListViewModel?.setSelectedCategory(category: category)
            XCTAssertNotNil(recommendListViewModel?.selectedCategory)
            XCTAssertEqual(recommendListViewModel?.selectedCategory, category)
            
            let recommends = CategoryAndRecommendRepository().recommends.filter {
                $0.categoryType == category.category
            }
            
            XCTAssertEqual(recommends, recommendListViewModel?.recommends)
        }
    }
    
    
    
    
    
}
