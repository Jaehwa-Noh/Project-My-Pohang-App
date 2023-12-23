//
//  CategoryViewModel.swift
//  My Pohang AppTests
//
//  Created by Jaehwa Noh on 12/23/23.
//

import XCTest
@testable import My_Pohang_App

final class CategoryViewModelTest: XCTestCase {

    private var categoryViewModel: CategoryViewModel?
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        categoryViewModel = CategoryViewModel()
    }

    override func tearDownWithError() throws {
        try super.tearDownWithError()
        categoryViewModel = nil
    }
    
    func test_CategoryViewModel_SetCategory_SetCategory() {
        XCTAssertEqual(categoryViewModel?.categories, CategoryAndRecommendRepository().categories)
    }

}
